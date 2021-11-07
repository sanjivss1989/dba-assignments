import axios from 'axios';

class DataServices{

    retrieveAllAppointments(){
      return axios.get('http://localhost:8080/groomerx/api/v1/appointments');
    }

    scheduleAppointment(appointment){
        return axios.post('http://localhost:8080/groomerx/api/v1/appointment', appointment);
    }
}

export default new DataServices