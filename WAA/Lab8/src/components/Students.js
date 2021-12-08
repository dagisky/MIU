const Students = ({students, handleDelete}) => {
    return ( 
        students.map((student)=>(
        <div className="student-item" key={student.id}>
            <h3>Student</h3>
            <p>Id:{student.id}</p>
            <p>Name:{student.name}</p>
            <p>Major:{student.major}</p>
            <button onClick={()=>{handleDelete(student.id)}}>Delete Student</button>
        </div>
        ))
     );
}
 
export default Students;