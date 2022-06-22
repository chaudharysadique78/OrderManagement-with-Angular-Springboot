import { Component, OnInit } from '@angular/core';
import Order from 'src/app/Entity/Order';
import { ActivatedRoute } from '@angular/router';
import { OrderService } from 'src/app/service/order.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  order: Order = new Order();
  alert;

  updateOrder() {
    this.orderService.updateOrder(this.order).subscribe(() => {
      console.log(this.order);
      this.alert = true;
    })
  }

  closeAlert(){
    this.alert = false;
  }

  constructor(public orderService: OrderService, public router: ActivatedRoute) { }

  ngOnInit(): void {
    this.orderService.getCurrentOrder(this.router.snapshot.params.id).subscribe(result => {
      console.log(result);
      this.order = result as Order;
    })
  }

}
