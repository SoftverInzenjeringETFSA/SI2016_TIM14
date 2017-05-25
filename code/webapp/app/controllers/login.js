import Ember from 'ember';
import user from '../models/user';

export default Ember.Controller.extend({
    userService: Ember.inject.service(),
    isToSAccepted: Ember.computed.not('isToSCheckboxChecked'),
     store: Ember.inject.service(),
    session: Ember.inject.service(),
    model: {},
    registracijamsg: '',

    
    
    actions: {

        login: function() {

            this.get('session').authenticate('authenticator:application', this.model, (data) => {
                    console.log(data);
                     //Ember.set(this, 'errorMessage', '');
                     this.set('model.username', '');
                     this.set('model.password', '');
                     this.set('model.confirmedpassword', '');
                     this.set('model.email', '');
                     this.transitionToRoute('profil');
                })
                .catch(reason => {
                    Ember.set(this, 'errorMessage', JSON.parse(reason.responseText).errorMessage);
                    this.set('authenticationError', this.errorMessage || reason);
                });
          },
		registerUser() {

			var regUsername = /^[a-zA-Z0-9]+$/;
			var wasError=false;
			if(!this.get('model.username').match(regUsername))
			{
				this.set('errorUsername','Username can contain only letters and numbers!');
				wasError=true;
			}
			else
			this.set('errorUsername','');	
            var regEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			if(!this.get('model.email').match(regEmail))
			{
				this.set('errorEmail','Email must be in example@something.com!');
				wasError=true;
			}
			else
			this.set('errorEmail','');
			var regPassword = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
			if(!this.get('model.password').match(regPassword))
			{
				this.set('errorPassword','Password must contain at least one number, uppercase letter, lowercase letter and at least 6 characters!');
				wasError=true;
			}
			else this.set('errorPassword','');
			if(this.get('model.password')!=this.get('model.confirmedPassword'))
			{
				this.set('errorConfirmedPassword','Passwords do not match!');
				wasError=true;
			}
			else this.set('errorConfirmedPassword','');
				
			if(!wasError)
			{
				
				let korisnik = this.getProperties('username', 'password', 'email');
				console.log()
				korisnik.username = this.get('model.username');
				korisnik.password = this.get('model.confirmedPassword');
				korisnik.email = this.get('model.email');
	        	this.get('userService').store(korisnik);
	        	this.set('model.username', '');
                this.set('model.password', '');
                this.set('model.confirmedPassword', '');
                this.set('model.email', '');
                Ember.set(this, 'registracijamsg', 'USPJEŠNA REGISTRACIJA. RADI POTVRDE PRIJAVITE SE!');
                //this.transitionToRoute('profil');
	        	
            }
           }

       }
	
    
});
