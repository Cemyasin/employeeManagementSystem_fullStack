import React, { Component } from 'react';

class HeaderComponent extends Component {

    constructor(props){
        super(props)
    
            this.state={
            }
        
    }
    render() {
        return (
            <div>
                <header>
                    <nav className='navbar navbar-expand md navbar-dark bg-dark'>
                    <div>
                        <a style={{ fontSize: '30px' }} href="https://www.linkedin.com/in/cem-yasin-uzum-268cyu/" target={'_blank'} className='navbar-brand'>Employee Management App</a></div>
                    </nav>
                </header>
            </div>
        );
    }
}

export default HeaderComponent;