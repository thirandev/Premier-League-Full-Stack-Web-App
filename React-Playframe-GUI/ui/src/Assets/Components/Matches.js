import React,{Component} from 'react';
import Nav from './Nav';
import './Match.css';

class Matches extends Component{
    state = {
        matches:[],
        searchDay:0,
        searchMonth:0,
        searchYear:0
    }
    details = () => {
        fetch('/api/matches')
            .then(response => response.json())
            .then(data => this.setState({ matches: data.response}));
    }
    componentDidMount() {
        this.details()
    }
    handleDateSearch = (event) =>{
        let myArray = event.target.value.split(/([0-9]+)/);
        this.setState({
            searchDay:parseInt(myArray[5]),
            searchMonth:parseInt(myArray[3]),
            searchYear:parseInt(myArray[1])
        })
    }
    render() {
        return(
            <div className={"wrapper"}>
                <div className={"nav-bar"}>
                    <Nav/>
                </div>
                <div className={"title-bar"}>Premier League Matches</div>
                <div className={"search"}>
                    <input className={"input"} type="date" onChange={this.handleDateSearch}/>
                </div>
                    <div className={"matches"}>
                        {this.state.matches
                            .filter((item)=>{
                                if (this.state.searchDay === 0){
                                    return item;
                                }else if((this.state.searchDay === item.date.day) &&
                                    (this.state.searchMonth === item.date.month)&&
                                    (this.state.searchYear === item.date.year)
                                ){
                                    return item;
                                }
                            })
                            .map((item,i) => (
                            <div key={i+1} className={"match"}>
                                <div key={i+2} className={"date"}>
                                    <div key={i+3} className={"day"}>{item.date.day}</div>
                                    <div key={i+4} className={"month"}>.{item.date.month}</div>
                                    <div key={i+5} className={"year"}>{item.date.year}</div>
                                </div>
                                <div key={i+6} className={"team1"}>
                                    <div key={i+7} className={"name"}>{item.team1.clubName}</div>
                                    <div key={i+8} className={"score"}>{item.score1}</div>
                                </div>
                                <div key={i+9} className={"vs"}>VS</div>
                                <div key={i+10} className={"team2"}>
                                    <div key={i+11} className={"name"}>{item.team2.clubName}</div>
                                    <div key={i+12} className={"score"}>{item.score2}</div>
                                </div>
                            </div>
                        ))}
                    </div>

            </div>
        );
    }
}
export default Matches ;
