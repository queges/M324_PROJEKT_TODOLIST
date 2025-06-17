// test/App.test.jsx
import React from 'react';
import { render, screen, fireEvent, waitFor } from '@testing-library/react';
import App from '../src/App';

beforeEach(() => {
  fetch.resetMocks();
});

test('renders todo list and adds a new todo', async () => {
  // Mock initial fetch to get todos
  fetch.mockResponseOnce(JSON.stringify([{ id: 1, taskdescription: 'Test Todo' }]));

  render(<App />);

  // Check if existing todo is rendered
  expect(await screen.findByText(/Task 1: Test Todo/i)).toBeInTheDocument();

  // Mock fetch for adding a todo
  fetch.mockResponseOnce(JSON.stringify({ id: 2, taskdescription: 'New Todo' }));

  // Type into input and submit
  fireEvent.change(screen.getByRole('textbox'), { target: { value: 'New Todo' } });
  fireEvent.click(screen.getByText(/Absenden/i));

  // Because your app reloads page after submit (window.location.href = '/'), you might want to mock that or avoid reload in tests.
  // For now just check if fetch was called with the POST request
  await waitFor(() => {
    expect(fetch).toHaveBeenCalledWith(
      'http://localhost:8080/task',
      expect.objectContaining({
        method: 'POST',
        body: JSON.stringify({ taskdescription: 'New Todo' }),
      }),
    );
  });
});

test('deletes a todo', async () => {
  // Mock initial fetch with one todo
  fetch.mockResponseOnce(JSON.stringify([{ id: 1, taskdescription: 'Delete Me' }]));

  render(<App />);

  expect(await screen.findByText(/Task 1: Delete Me/i)).toBeInTheDocument();

  // Mock fetch for delete request
  fetch.mockResponseOnce(JSON.stringify({}));

  // Click the Done button (✓)
  fireEvent.click(screen.getByText('✔'));

  // Check if DELETE fetch was called with correct URL
  await waitFor(() => {
    expect(fetch).toHaveBeenCalledWith(
      'http://localhost:8080/task/1',
      expect.objectContaining({
        method: 'DELETE',
      }),
    );
  });
});
