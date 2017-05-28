import Ember from 'ember';
import ban from '../models/ban';

export default Ember.Controller.extend({
	banRequestService: Ember.inject.service('banrequest-service'),
	session: Ember.inject.service(),
	Message: '',
	Message2: '',

	actions: {
		 banujKorisnika(idbanovikorisnik, idgrupa, idBanZahtjeva) {

           this.get('banRequestService').prihvatiZahtjevZaBan(idbanovikorisnik, idgrupa, idBanZahtjeva);
           Ember.set(this, 'Message', 'Uspješno banovan korisnik!');
           window.location.reload(true); 
	},
        
        odbijbanKorisnika(idBan) {

               this.get('banRequestService').odbijZahtjevZaBan(idBan);     
               Ember.set(this, 'Message', 'Uspješno ste odbili zahtjev za ban!');
               window.location.reload(true); 

		}

	}

});