import { useState } from "react";
const Student = ({student, handleOnSubmit}) => {   
    const [name, setName] =  useState('');

    return ( 
        <div className="student-display">
            <form>
                <input id="nameVal" onChange={(e) => setName(e.target.value)} value={name}/>
                <span className="button" onClick={(e)=>{handleOnSubmit(name)}} > Change Name </span>       
            </form>
            <h3>Student</h3>
            <p>Id:{student.id}</p>
            <p>Name:{student.name}</p>
            <p>Major:{student.major}</p>
        </div>
     );
}
 
export default Student;