import { ClassDtlDataDto } from "./class-dtl.data.dto";

export class ClassDtlListResDto{
    private _data : ClassDtlDataDto[] = []

    public get data(): ClassDtlDataDto[] {
        return this._data;
    }

    public set data(data: ClassDtlDataDto[]) {
        this._data = data;
    }

}