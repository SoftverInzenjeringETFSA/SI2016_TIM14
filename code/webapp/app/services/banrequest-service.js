import Ember from 'ember';
import BaseService from './base-service';
import Ban from '../models/ban';

export default BaseService.extend({
    session: Ember.inject.service(),
    all: function() {
        var banovi = [];
        this.ajax({ url: `banzahtjevi/all`, type: "GET"}).then(function(data) {
            data.forEach(function(ban) {
                banovi.addObject(Ban.create(ban));
            });

        });
        return banovi;
    },

    prihvatiZahtjevZaBan: function(idbanovikorisnik, idgrupa, idBan){
       
       this.ajax({ url: `banzahtjevi/prihvatizahtjev`, type: "POST", data: {idbanovikorisnik:idbanovikorisnik, idgrupa:idgrupa, idBan:idBan}}).then(function(data) {
        });
        return true;

    },


    odbijZahtjevZaBan: function(idBan){

      this.ajax({ url: `banzahtjevi/odbijzahtjev`, type: "POST", data: {idBan:idBan}}).then(function(data) {
        });
        return true;

    }

});