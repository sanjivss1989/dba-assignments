import react, {Component} from "react";
import LoginComponent from "./login/LoginComponent";
import WelcomeComponent from "./welcome/WelcomeComponent";
import ListAppointments from "./listappointments/listappointments";
import AppointmentComponent from "./appointments/appointmentcomponent"
import {BrowserRouter as Router, Route, Switch}from 'react-router-dom';
import HeaderComponent from "./header/HeaderComponent";
import FooterComponent from "./footer/FooterComponent";
import LogoutComponent from "./logout/LogoutComponent";


class GroomerXApp extends Component{

    render(){
        return(
            <div className="GroomerXApp">
                <Router>
                    <>
                    <HeaderComponent/>
                    <Switch>
                    <Route path = "/" exact component={LoginComponent}/>
                    <Route path = "/login" component={LoginComponent}/>
                    <Route path = "/welcome/:username" component={WelcomeComponent}/>
                    <Route path = "/listappointments" component={ListAppointments}/>
                    <Route path = "/logout" component={LogoutComponent}/>
                    <Route path = "/appointments" component={AppointmentComponent}/>
                    <Route  component={ErrorPage}/>
                    </Switch>
                    <FooterComponent/>
                    </>
                </Router>
              
                <br/>
                <br/><br/><br/>
            </div>
        )
    }

}

function ErrorPage(){
    return <div>Page Not Found</div>
}

export default GroomerXApp;