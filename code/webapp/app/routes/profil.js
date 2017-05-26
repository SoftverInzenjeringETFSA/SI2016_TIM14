import Ember from 'ember';

export default Ember.Route.extend({
	ajax: Ember.inject.service(),
	session: Ember.inject.service(),

    model() {

    	// return this.ajax({ url: `korisnici/getprofile`, type: "POST", data: this.get('session.data.authenticated.korisnik.username');})
    	//console.log(this.get('session.data.authenticated.korisnik.username'));
    	//return this.get('ajax').request('http://localhost:8080/korisnici/getprofile', { method: 'POST', data: this.get('session.data.authenticated.korisnik.username')});
    }
});
