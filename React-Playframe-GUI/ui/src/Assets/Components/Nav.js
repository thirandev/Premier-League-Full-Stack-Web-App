import React from 'react';
import Logo from '../Image/logopm.png';
import Title from '../Image/textpm.png';
import Vector from '../Image/Vector.png';
import './Nav.css';
import {Link} from "react-router-dom";

function Nav(){
    return(
    <div className="nav-items">
        <nav>
            <img className="vector" src={Vector} alt="Vector"/>
            <img className="logo" src={Logo} alt="Logo"/>
            <img className="pl" src={Title} alt="Premier League"/>
            <ul className="nav-links">
                <Link to="/" className="hyperlink">
                    <li>HOME</li>
                </Link>
                <Link to="/table" className="hyperlink">
                    <li>TABLE</li>
                </Link>
                <Link to="/matches" className="hyperlink">
                    <li>MATCHES</li>
                </Link>
            </ul>
        </nav>
    </div>
    );
}
export default Nav;
