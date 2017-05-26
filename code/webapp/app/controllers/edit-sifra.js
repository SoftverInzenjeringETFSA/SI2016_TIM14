import Ember from 'ember';
import user from '../models/user';

export default Ember.Controller.extend({
	userService: Ember.inject.service('userService'),
	session: Ember.inject.service(),
	actions: {
		 promijeniSifru() {
			var novaSifra = this.get('newpassword');
			var potvrdenaSifra = this.get('newconfirmedPassword');
      var wasError=false;
			var regPassword = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
			if(!novaSifra.match(regPassword))
			{
				this.set('errorNewPassword','Password must contain at least one number, uppercase letter, lowercase letter and at least 6 characters!');
				wasError=true;
			}
      else this.set('errorNewPassword','');
      if(novaSifra!=potvrdenaSifra)
			{
				this.set('errorConfirmedPassword','Passwords do not match!');
				wasError=true;
			}
			else this.set('errorConfirmedPassword','');
      if(!wasError){
			this.get('userService').changePassword(novaSifra, this.get('session.data.authenticated.korisnik.username'));
      }
		}
	}
});
