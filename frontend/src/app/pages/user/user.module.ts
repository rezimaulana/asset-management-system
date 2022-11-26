import { NgModule } from "@angular/core";
import { UserRouting } from "./user.routing";
import { UserListComponent } from "./list/user-list.component";
import { UserInsertComponent } from "./insert/user-insert.component";
import { UserUpdateComponent } from "./update/user-update.component";

@NgModule({
    declarations : [
        UserListComponent, UserInsertComponent, UserUpdateComponent
    ],
    imports : [
        UserRouting
    ],
    exports : [
        UserListComponent, UserInsertComponent, UserUpdateComponent
    ]
})

export class UserModule{}