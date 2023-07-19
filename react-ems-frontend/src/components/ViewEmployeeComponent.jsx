import React, { Component } from 'react';
import EmployeeService from '../services/EmployeeService';

class ViewEmployeeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            employee : {}
        }

    }
    componentDidMount(){
        EmployeeService.getEmployeeById(this.state.id).then(res =>
            this.setState({employee: res.data}));
    }
    goBack(){
        this.props.history.push('/employees');
    }
    render() {
        return (
            <div>
                <br /><br />
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center'>View Employee Details</h3>
                    <div className='card-body'>
                        <div className='row'>
                            <label >First Name: {this.state.employee.firstName}</label>
                            <div></div>
                        </div>
                        <div className='row'>
                            <label >Last Name: {this.state.employee.lastName}</label>
                            <div></div>
                        </div>
                        <div className='row'>
                            <label >Email Address: {this.state.employee.email}</label>
                        </div>
                       
                    </div> <button className='btn btn-info' onClick={this.goBack.bind(this)}>Go Back</button>
                </div>
            </div>
        );
    }
}

export default ViewEmployeeComponent;