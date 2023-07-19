import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';

class CreateEmployeeComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            firstName: "",
            lastName: "",
            email: ""
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changelastNameHandler = this.changelastNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.saveOrUpdateEmployee = this.saveOrUpdateEmployee.bind(this);
    }

    componentDidMount() {

        if (this.state.id === '_add') {
            return
        } else {
            EmployeeService.getEmployeeById(this.state.id).then((res) => {
                let employee = res.data;
                this.setState({
                    firstName: employee.firstName, lastName: employee.lastName,
                    email: employee.email
                });
            });
        }

    }

    saveOrUpdateEmployee(e) {
        e.preventDefault();


        if (this.state.id === '_add') {
            let employee = { firstName: this.state.firstName, lastName: this.state.lastName, email: this.state.email };
            console.log('employee =>' + JSON.stringify(employee));
            EmployeeService.createEmployee(employee).then(res => {
                this.props.history.push("/employees");
            });
        } else {
            let employee = { id: this.state.id, firstName: this.state.firstName, lastName: this.state.lastName, email: this.state.email };
            console.log('employee =>' + JSON.stringify(employee));
            EmployeeService.updateEmployee(employee).then(res => {
                this.props.history.push("/employees");
            });
        }

    }

    changeFirstNameHandler(event) {
        this.setState({ firstName: event.target.value });
    }
    changelastNameHandler(event) {
        this.setState({ lastName: event.target.value });
    }
    changeEmailHandler(event) {
        this.setState({ email: event.target.value });
    }
    cancel() {
        this.props.history.push('/employees');
    }

    getTitle() {
        if (this.state.id === '_add') {
            return <h3 className='text-center h3'>Add Employee</h3>
        } else {
            return <h3 className='text-center h3'>Update Employee</h3>
        }
    }

    render() {
        return (
            <div>
                <br /><br />
                <div className='container'>
                    <div className='row'>
                        <div className={'card col-md-6 offset-md-3'} >
                            {this.getTitle()}
                            <div className='card-body'></div>
                            <form >
                                <div className='form-group'>
                                    <label>First Name: </label>
                                    <input placeholder='First Name' name='firstName' className='form-control' value={this.state.firstName}
                                        onChange={this.changeFirstNameHandler} />
                                </div>
                                <div className='form-group'>
                                    <label>Last Name: </label>
                                    <input placeholder='Last Name' name='lastName' className='form-control' value={this.state.lastName}
                                        onChange={this.changelastNameHandler} />
                                </div>
                                <div className='form-group'>
                                    <label>Email: </label>
                                    <input placeholder='Email' name='email' className='form-control' onChange={this.changeEmailHandler}
                                        defaultChecked={true} />
                                </div>
                                <button className='btn btn-success' onClick={this.saveOrUpdateEmployee}>Save</button>
                                <button className='btn btn-danger' onClick={this.cancel.bind(this)} style={{ marginLeft: "10px" }}>Cancel</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default CreateEmployeeComponent;