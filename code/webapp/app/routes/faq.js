import Ember from 'ember';

export default Ember.Route.extend({
  ajax: Ember.inject.service(),
  session: Ember.inject.service(),
   model() {
    	let id = this.get('session.data.authenticated.korisnik.id');
    	if(Ember.isNone(id)){
    		this.transitionTo('login');
    	}
    }
});
