import React from 'react';
import Logo from '../Image/logopm.png';
import Title from '../Image/textpm.png';
import TableBtn from '../Image/tablebtn.png';
import MatchesBtn from '../Image/matchesbtn.png';
import './Home.css';
import { Link } from "react-router-dom";

class Home extends React.Component {

    render() {

      return (
            <div>
                <img className="logoNav" src={Logo} alt="Logo"/>
                <img className="titleNav" src={Title} alt="Title"/>
                <Link to="/table">
                  <img src={TableBtn} className="tableBtn" alt="Button"/>
                </Link>
                <Link to="/matches">
                  <img className="matchesBtn" src={MatchesBtn} alt="Button"/>
                </Link>
            </div>
         
      );
    }
  }
  
  export default Home;