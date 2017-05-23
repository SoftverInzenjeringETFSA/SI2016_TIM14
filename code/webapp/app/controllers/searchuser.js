import Ember from 'ember';
import user from '../models/user';

export default Ember.Controller.extend({
		userService: Ember.inject.service(),
		ajax: Ember.inject.service(),
    model: {},
    model()
    {},
    test: function()
    {
    	console.log('HELLO');
    },
    actions: {
        
		searchUser() {
			console.log('Say something')
			/*let korisnik = this.getProperties('username', 'password', 'email');
			console.log()
			korisnik.username = this.get('model.username');
			korisnik.password = this.get('model.confirmedPassword');
			korisnik.email = this.get('model.email');
        	this.get('userService').store(korisnik);
			//check();*/
			var email = this.get('model.searchUserEmail');
			var dataForReturn;
            var dataUser = this.get('ajax').request('http://localhost:8080/korisnici/searchUserPerEmail', { method: 'POST',dataType: 'string', data: email});
            /*dataUser.then(function(data) {
            	this.send('fuck');
            	dataForReturn = data;
        	});*/
        	this.send('test');
        	console.log(dataUser);
        	return dataUser;
        },
         fuck : function(){
    	console.log('Hi dog 2')
    },

      
		
    }
});
