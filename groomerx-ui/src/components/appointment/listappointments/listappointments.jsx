import React, {Component} from "react";
import DataServices from "../DataServices.js";

class ListAppointments extends Component{

    constructor(props){
        super(props);
        this.state= {
            appointmentsList : []
           
        }
        this.refreshAppointmentList = this.refreshAppointmentList.bind(this);
        this.scheduleAppointmentClicked = this.scheduleAppointmentClicked.bind(this);
     
    }

    // componentWillUnmount() {
    //     console.log('componentWillUnmount')
    // }

    // shouldComponentUpdate(nextProps, nextState) {
    //     console.log('shouldComponentUpdate')
    //     console.log(nextProps)
    //     console.log(nextState)
    //     return true
    // }

    componentDidMount() {
        console.log('componentDidMount')
        this.refreshAppointmentList();
        console.log(this.state)
    }

    refreshAppointmentList() {
        DataServices.retrieveAllAppointments()
            .then(
                response => {
                    console.log(response)
                    this.setState({ appointmentsList: response.data.appointments })
                }
            )
    }

    scheduleAppointmentClicked(){
       this.props.history.push('/appointments')
    }

    render(){
        return(
            <div>
                <h1>Appointment List</h1>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Scheduled By</th>
                                <th>Assigned To</th>
                                <th>Client</th>
                                <th>Scheduled Time</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                               this.state.appointmentsList.map(
                                row =>
                                    <tr key={row.appointmentID}>
                                        <td>{row.appointmentID}</td>
                                        <td>{row.scheduledBy}</td>
                                        <td>{row.assignedTo}</td>
                                        <td>{row.clientName}</td>
                                        <td>{row.scheduledAt}</td>
                                        <td>
                                        <button type ="button" className="btn btn-primary btn-sm mr-1">Cancel</button>
                                        <button type ="button" className="btn btn-primary btn-sm mr-1">Reschedule</button>
                                       </td>
                                    </tr>
                            )
                            }
                        </tbody>
                        
                    </table>
                    <div className="row">
                        <button className="btn btn-success btn-sm" onClick={this.scheduleAppointmentClicked}>Schedule New Appointment</button>
                    </div>
               
                </div>
            </div>
            
        )


    }

}



export default ListAppointments;