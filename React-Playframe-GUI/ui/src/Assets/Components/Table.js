import React,{Component} from 'react';
import Nav from './Nav';
import './Table.css';


class Table extends Component{
    state = {
        data:[],
        requestUrl:'/api/clubs',
        matchData:[],
        loadMatch:false
    }

    details = () => {
            fetch(this.state.requestUrl )
                .then(response => response.json())
                .then(data => this.setState({ data: data.response}));
    }
    match = () => {
        fetch('/api/matches/generate' )
            .then(response => response.json())
            .then(data => this.setState({ matchData: data.response,
                loadMatch:true,
            }));
    }

    componentDidMount() {
        this.details()
    }

    componentDidUpdate(prevProps,prevState) {
        if (this.state.requestUrl !== prevState.requestUrl) {
            this.details();
        }
    }

    render() {
        return(
            <div className={"main-wrap"}>
                <div className={"nav"}>
                    <Nav/>
                </div>
                <div className={"title"}>Premier League Table</div>
                <div className={"sort"}>
                    <div onClick={()=>this.setState({requestUrl:'/api/clubs'})}>
                        Sort By Points
                    </div>
                    <div onClick={()=>this.setState({requestUrl:'/api/clubs/score'})}>
                        Sort By Score
                    </div>
                    <div onClick={()=>this.setState({requestUrl:'/api/clubs/wins'})}>
                        Sort By Wins
                    </div>
                </div>
                <div className={"table"}>
                    <div className={"headings"}>
                        <div className={"club"}>Club</div>
                        <div className={"location"}>Location</div>
                        <div>Wins</div>
                        <div>Draws</div>
                        <div>Lost</div>
                        <div>GF</div>
                        <div>GA</div>
                        <div>GD</div>
                        <div>Played</div>
                        <div>Points</div>
                    </div>
                        {this.state.data.map((item,index) => {
                            return(
                            <div className={"data"}  key={index+"a"}>
                                <div className={"club"} key={index+"b"}>{item.clubName}</div>
                                <div className={"location"} key={index+"c"}>{item.clubLocation}</div>
                                <div key={index+"d"}>{item.noOfWins}</div>
                                <div key={index+"e"}>{item.noOfDraws}</div>
                                <div key={index+"f"}>{item.noOfDefeats}</div>
                                <div key={index+"g"}>{item.goalsFor}</div>
                                <div key={index+"h"}>{item.goalsAgainst}</div>
                                <div key={index+"i"}>{item.goalDifference}</div>
                                <div key={index+"j"}>{item.matchesPlayed}</div>
                                <div key={index+"k"}>{item.points}</div>
                            </div>
                            )
                        })}
                </div>
                <div className={"generate"}>
                    <div className={"random-btn"} onClick={this.match}>Random</div>
                    {this.state.loadMatch && (
                        <div className={"match-data"}>
                            <div className={"club1"}>{this.state.matchData.team1.clubName}</div>
                            <div className={"score1"}>{this.state.matchData.score1}</div>
                            <div className={"score2"}>{this.state.matchData.score2}</div>
                            <div className={"club2"}>{this.state.matchData.team2.clubName}</div>

                        </div>
                    )}
                </div>
            </div>
        );
    }
}
export default Table ;