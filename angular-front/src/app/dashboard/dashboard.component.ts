import { Component} from '@angular/core';
import { top5, gender, multi } from './data';


@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
    multi: any[];
    obj: any[];
    top5: any[];
    gender: any[];
    top5Legend: string = 'Merchant Id';
    view: any[] = [700, 400];

    // pie & bar
    showXAxis = true;
    showYAxis = true;
    gradient = true;
    showLegend = true;
    showXAxisLabel = true;
    xAxisLabel = 'Country';
    showYAxisLabel = true;
    yAxisLabel = 'Population';

    //pie charts
    animations = true;
    labels = true;

    colorScheme = {
      domain: ['#1E1F35', '#5779C8', '#FFC64C', '#FF6737', '#E75047']
    };

    constructor() {
      Object.assign(this, { top5, gender, multi });
    }
}
