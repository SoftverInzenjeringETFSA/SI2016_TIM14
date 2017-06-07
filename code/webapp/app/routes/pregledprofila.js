import Ember from 'ember';

export default Ember.Route.extend({
	userService: Ember.inject.service('user-service'),
    ajax: Ember.inject.service(),
	session: Ember.inject.service(),

     model: function(params, transition) {
         let id = this.get('session.data.authenticated.korisnik.id');
        if(Ember.isNone(id)){
            this.transitionTo('login');
        } 
           
         var term = params.term;
         return this.get('ajax').request(`http://localhost:8080/korisnici/getprofile?term=${term}`, { method: 'GET' });

      /*let user = this.get('userService').getProfile(params.term);
        console.log(user);
        return Ember.RSVP.hash({
            searchedUser: user
        });*/
    }
	
});
