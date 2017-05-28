import Ember from 'ember';
import User from '../models/user';

export default Ember.Controller.extend({
	userService: Ember.inject.service('user-service'),
	session: Ember.inject.service(),
	Message: '',

	actions: {
		 obrisiUsera(iduser) {

           this.get('userService').deleteUser(iduser);
           Ember.set(this, 'Message', 'Uspješno obrisan korisnik!');
           window.location.reload(true); 
	   }
	}

});