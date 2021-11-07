import react, {Component} from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import DataServices from '../DataServices';
import { a } from '@react-spring/web';


class AppointmentComponent extends Component{

    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            scheduledBy: '',
            assignedTo: '',
            clientName: '',
            dateOfAppointment: '',
            startTime: '',
            endTime :'',
            endTimeExpected: '',
            discount: ''


        
        }

       this.onSubmit = this.onSubmit.bind(this); 
       this.validate = this.validate.bind(this);

    }

    componentDidMount(){
       if(this.state.id===-1){
          return
       }
    }

    onSubmit(values) {
        console.log(values)
  
        let appointment ={
            employeeCreated: values.scheduledBy,
            employeeID: values.assignedTo,
            clientName: values.clientName,
            clientContact: '9382927499',
            clientEmail: '2020mt93511@wilp.bits-pilani.ac.in',
            services: [
                {
                    id: '1',
                    serviceName: 'Haircut',
                    duration: 30,
                    price: 120.00
                },
                {
                    id: '6',
                    serviceName: 'Facewash',
                    duration: '30',
                    price: '120.00'
                }
            ],
            startTime:values.dateOfAppointment+' '+values.startTime,
            endTime: values.dateOfAppointment+' '+'13:30',
            endTimeExpected: values.dateOfAppointment+' '+'13:30',
            discount: '10'

        }
        console.log(JSON.stringify(appointment))
         
              DataServices.scheduleAppointment(appointment)
              .then(() => this.props.history.push('/listappointments'))
          

        }
       
    

    validate(values) {
        let errors = {}
        if (!values.scheduledBy) {
            errors.scheduledBy = 'Enter your ID';
        } else if (values.scheduledBy.length < 1) {
            errors.scheduledBy = 'Enter atleast 1 Characters in scheduled by field';
        }
         if (!values.assignedTo) {
            errors.assignedTo = 'Please enter the ID whom to assign'
        }
        if (!values.clientName) {
            errors.clientName = 'Please enter the client name'
        }
        if (values.clientName.length<4) {
            errors.clientName = 'Name should be at least 4 characters long'
        }


        return errors

    }
    render(){
        
        let { scheduledBy, assignedTo, clientName, dateOfAppointment, startTime, endTime, endTimeExpected, discount } = this.state
        return(
            <div>
              <h1>Schedule Appointment</h1>
              <div className="container">
                  <Formik 
                  initialValues={{scheduledBy,assignedTo, clientName, dateOfAppointment, startTime, endTime, endTimeExpected, discount}}
                  onSubmit={this.onSubmit}
                  validateOnChange={false}
                  validateOnBlur={false}
                  validate={this.validate}
                  enableReinitialize={true}
               >
                   {

(props) => (
                      <Form>
                        <ErrorMessage name="scheduledBy" component="div"
                        className="alert alert-warning" />
                        <ErrorMessage name="assignedTo" component="div"
                        className="alert alert-warning" />
                         <ErrorMessage name="clientName" component="div"
                        className="alert alert-warning" />
                
                                   <fieldset className="form-group">
                                        <label>Scheduled By</label>
                                        <Field className="form-control" type="text" name="scheduledBy" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Assign To</label>
                                        <Field className="form-control" type="text" name="assignedTo" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Client Name</label>
                                        <Field className="form-control" type="text" name="clientName" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Date</label>
                                        <Field className="form-control" type="text" name="dateOfAppointment" />
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Start Time</label>
                                        <Field className="form-control" type="text" name="startTime" />
                                    </fieldset>
                                   
                                    <fieldset className="form-group">
                                        <label>Discount</label>
                                        <Field className="form-control" type="text" name="discount" />
                                    </fieldset>
                                    
                                    <br/>
                                    <button className="btn btn-success" type="submit">Save</button>
                         
                      </Form>
)}
                  </Formik>
              </div>
            </div>
        )
    }
}
export default AppointmentComponent