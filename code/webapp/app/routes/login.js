import Ember from 'ember';

export default Ember.Route.extend({
	userService: Ember.inject.service(),
	model: function(params, transition) {

        return Ember.RSVP.hash({
            korisnici: this.get('userService').all()
        });
    }
});
