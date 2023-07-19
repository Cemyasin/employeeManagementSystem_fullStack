import React, { Component } from 'react';

class FooterComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {

        }

    }

    render() {
        return (
            <div>
                <footer className='footer' style={{fontSize: '18px'}}>
                    All Rights Reserved 2023 @CemYasinÜzüm
                </footer>

            </div>
        );
    }
}

export default FooterComponent;