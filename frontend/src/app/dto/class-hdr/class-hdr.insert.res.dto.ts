import { ClassHdrInsertDataResDto } from "./class-hdr.insert.data.res.dto";

export class ClassHdrInsertResDto{
    private _data! : ClassHdrInsertDataResDto
	private _message! : string

    public get data(): ClassHdrInsertDataResDto {
        return this._data;
    }

    public set data(data: ClassHdrInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}