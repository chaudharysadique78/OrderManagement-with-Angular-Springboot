import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


const BASE_URL="http://localhost:8089/";

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  createUser(order:{id:number,orderName:string,orderPrice:number,brand:string}){
    return this.http.post(BASE_URL+'saveorder',order);
  }

  getOrder(){
    return this.http.get(BASE_URL+'findallorder');
  }

  deleteOrder(order:any){
    return this.http.delete(BASE_URL+'deleteorder/'+order.id);
  }
 getCurrentOrder(id){
  return this.http.get(BASE_URL+'findorder/'+id);
 }

 updateOrder(order:any){
  return this.http.put(BASE_URL+'updateorder/'+order.id,order);
 }

  constructor(public http:HttpClient) { }
}
