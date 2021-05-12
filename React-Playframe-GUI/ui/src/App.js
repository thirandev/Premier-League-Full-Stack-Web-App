import React,{Component} from 'react';
import Home from './Assets/Components/Home.js';
import Matches from './Assets/Components/Matches';
import Table from './Assets/Components/Table';
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom';

class App extends Component{
 render(){
   return(
    <Router>
      <Switch>
        <Route path="/" exact component={Home}/>
        <Route path="/matches" component={Matches}/>
        <Route path="/table" component={Table}/>
      </Switch>
    </Router>
   )
 }
}
export default App;
