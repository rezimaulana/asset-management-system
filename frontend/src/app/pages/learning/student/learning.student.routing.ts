import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";

const routes : Routes = [
    {
        path : 'class-dtl/:id',
        loadChildren : () => import('./schedule/learning-schedule.student.module').then(mod => mod.LearningScheduleModuleStudent)
    }
];

@NgModule({
    imports : [
        RouterModule.forChild(routes)
    ],
    exports : [
        RouterModule
    ]
})

export class LearningRoutingStudent{}