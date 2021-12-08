import Students from "./Students";
import Student from "./Student";

const Dashboard = ({students, handleDelete, handleOnSubmit}) => {
    return ( 
        <div className="container">
            <h3>Title of the lab is lab9</h3>
            <div className="students-list">
                <Students students={students} handleDelete = {handleDelete}/>
            </div>
            
            {students && <Student student={students[0]} handleOnSubmit={handleOnSubmit}/>}
        </div>
     );
}

export default Dashboard;
