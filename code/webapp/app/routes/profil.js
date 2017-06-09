import Ember from 'ember';

export default Ember.Route.extend({
	ajax: Ember.inject.service(),
	session: Ember.inject.service(),

    model() {
         let id = this.get('session.data.authenticated.korisnik.id');
        if(Ember.isNone(id)){
            this.transitionTo('login');
        }
    	 let korisnik = this.getProperties('username','password');
         korisnik.username = this.get('session.data.authenticated.korisnik.username');
         korisnik.password = this.get('session.data.authenticated.korisnik.password');

                this.get('session').authenticate('authenticator:application', korisnik, (data) => {
                    console.log(data);
                })
                .catch(reason => {
                    //Ember.set(this, 'errorMessage', JSON.parse(reason.responseText).errorMessage);
                    this.set('authenticationError', this.errorMessage || reason);
                });

    	// return this.ajax({ url: `korisnici/getprofile`, type: "POST", data: this.get('session.data.authenticated.korisnik.username');})
    	//console.log(this.get('session.data.authenticated.korisnik.username'));
    	//return this.get('ajax').request('http://localhost:8080/korisnici/getprofile', { method: 'POST', data: this.get('session.data.authenticated.korisnik.username')});
    }

});
