import Ember from 'ember';

export default Ember.Route.extend({
	session: Ember.inject.service(),
	ajax: Ember.inject.service(),
    model() {
    	let id = this.get('session.data.authenticated.korisnik.id');
        if(Ember.isNone(id)){
            this.transitionTo('login');
        } 
    	return this.get('ajax').request('http://localhost:8080/banzahtjevi/all', { method: 'GET' });
    }
});
