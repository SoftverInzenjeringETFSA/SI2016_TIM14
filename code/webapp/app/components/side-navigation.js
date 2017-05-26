import Ember from 'ember';

export default Ember.Component.extend({
 session: Ember.inject.service(),

  isAdmin: function() {
    console.log(this.get('session.data.authenticated.korisnik.isAdmin'));
  return this.get('session.data.authenticated.korisnik.isAdmin');
}


});
