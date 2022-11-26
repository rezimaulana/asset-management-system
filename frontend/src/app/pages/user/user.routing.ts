import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentSuperAdmin } from "../../components/content/super-admin/content.super-admin.component";
import { UserListComponent } from "./list/user-list.component";
import { UserInsertComponent } from "./insert/user-insert.component";
import { UserUpdateComponent } from "./update/user-update.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentSuperAdmin,
        children : [
            {
                path: "",
                component : UserListComponent
            },
            {
                path: "new",
                component : UserInsertComponent
            },
            {
                path: "edit/:id",
                component : UserUpdateComponent
            }
        ]
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

export class UserRouting{}