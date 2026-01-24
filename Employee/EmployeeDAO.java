public CREATE DATABASE employer;

// CREATE TABLE worker (
//     id INT PRIMARY KEY,
//     employee_name VARCHAR(50) NOT NULL,
//     position VARCHAR(50),
//     department VARCHAR(50),
//     time_in TIME,
//     time_out TIME,
//     time_stamp DATE,
//     area VARCHAR(50)
// ); {
    
// }


// employee.java design
// package declaration

// import statements (LocalTime, etc.)

// public class Employee {

//     // 1️⃣ FIELDS (private)
//     - id
//     - name
//     - position
//     - department
//     - timeIn
//     - timeOut

//     // 2️⃣ CONSTRUCTOR(S)
//     - ginagamit pag nag create ng employee
//     - dito nilalagay ang time-in logic

//     // 3️⃣ GETTERS / SETTERS
//     - getId()
//     - getName()
//     - setTimeOut()

//     // 4️⃣ OVERRIDE
//     - toString()   ← DITO LANG MAY @Override
// }

// DAO design structure

// package declaration

// import statements (Connection, PreparedStatement, ResultSet)

// public class EmployeeDAO {

//     // 1️⃣ FIELD
//     - Connection (galing DatabaseConnection)

//     // 2️⃣ CONSTRUCTOR
//     - kinukuha ang connection

//     // 3️⃣ METHODS (CRUD)
//     - insertEmployee()
//     - getAllEmployees()
//     - updateTimeOut()
//     - findById()

// }
