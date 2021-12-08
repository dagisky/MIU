import './App.css';
import React, { useState, useCallback } from 'react';
import Dashboard from './components/Dashboard';

function App() {
  const [students, setStudents] = useState([
    {id:111, name:'Meti', major:'cs'},
    {id:112, name:'Tedros', major:'cs'},
    {id:113, name:'Pascal', major:'cs'}
  ]);
  const handleDelete = (id) => {
    setStudents(students.filter((student) => student.id !== id));
  } 
 
  const handleOnSubmit = useCallback(
    (name) => {
    students[0].name = name;
    setStudents([...students]);
    },
    [students],
  )
  
  return (
    <div className="App">
        {students.length > 0 && <Dashboard students={students} handleDelete={handleDelete} handleOnSubmit={handleOnSubmit}/>}
    </div>
  );
}

export default App;
