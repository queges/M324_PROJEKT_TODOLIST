import './App.css';
import React from 'react';

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      todos: props.todos || [],
      taskdescription: ""
    };
  }

  handleChange = event => {
    this.setState({ taskdescription: event.target.value });
  }

  handleSubmit = event => {
    event.preventDefault();
    if (this.state.taskdescription.trim() === "") return;

    fetch("http://localhost:8080/tasks", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ taskdescription: this.state.taskdescription })
    })
      .then(response => {
        this.setState(prevState => ({
          todos: [...prevState.todos, { taskdescription: prevState.taskdescription }],
          taskdescription: ""
        }));
      })
      .catch(error => console.log(error));
  }

  componentDidMount() {
    fetch("http://localhost:8080")
      .then(response => response.json())
      .then(data => this.setState({ todos: data }))
      .catch(error => console.log(error));
  }

  handleClick = taskdescription => {
    fetch(`http://localhost:8080/delete`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ taskdescription })
    })
      .then(() => {
        this.setState(prevState => ({
          todos: prevState.todos.filter(t => t.taskdescription !== taskdescription)
        }));
      })
      .catch(error => console.log(error));
  }

  renderTasks(todos) {
    return (
      <ul className="todo-list">
        {todos.map((todo, index) => (
          <li key={index}>
            <span>{todo.taskdescription}</span>
            <button onClick={() => this.handleClick(todo.taskdescription)}>✔️ Erledigt</button>
          </li>
        ))}
      </ul>
    );
  }

  render() {
    return (
      <div className="app-wrapper">
        <h1>📝 Meine ToDo-Liste</h1>
        <form onSubmit={this.handleSubmit} className="todo-form">
          <input
            type="text"
            placeholder="Was willst du erledigen?"
            value={this.state.taskdescription}
            onChange={this.handleChange}
          />
          <button type="submit">Hinzufügen</button>
        </form>
        {this.renderTasks(this.state.todos)}
      </div>
    );
  }
}

export default App;
