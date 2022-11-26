import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";

const routes : Routes = [
    {
        path : 'class-dtl/:id',
        loadChildren : () => import('./schedule/quiz-schedule.student.module').then(mod => mod.QuizScheduleModuleStudent)
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

export class QuizRoutingStudent{}