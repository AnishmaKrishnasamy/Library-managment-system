import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Passenger } from './Interfaces/Passenger';

@Injectable({
  providedIn: 'root'
})
export class PassengerService {

  constructor(public http: HttpClient) { }  // DI for HttpClient

  private apiUrlps = "http://localhost:9090/passenger";


  getAll_Passenger() : Observable<Passenger[]> {
    return this.http.get<Passenger[]>(this.apiUrlps+"/getAll");
  }

  
  
  storePassenger(passenger: any) :Observable<string> {
    return this.http.post(this.apiUrlps+"/store",passenger,{responseType:'text'});
  }

  

  delete_Passenger(pEmail: string):Observable<string> {
    return this.http.delete(this.apiUrlps+"/delete/"+pEmail,{responseType:"text"});
  }

 

  update_Passenger(uEmail: any, passenger:any):Observable<string> {
    return this.http.put(this.apiUrlps+"/update/"+uEmail, passenger,{responseType:"text"})
  }

  

  login(passenger: Passenger) :Observable<string> {
    return this.http.post(this.apiUrlps+"/login",passenger,{responseType:'text'});
    // return this.http.get("http://localhost:8585/passenger/login/"+uEmail+"/"+uPassword,{responseType:"text"})
  }

}