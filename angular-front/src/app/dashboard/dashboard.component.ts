import { Component} from '@angular/core';
import { single, multi } from './data';

@Component({
    selector: 'app-dashboard',
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {
    single: any[];
    multi: any[];

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
      Object.assign(this, { single });
    }
}
