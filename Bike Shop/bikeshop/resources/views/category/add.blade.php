@extends('layouts.master') 
@section('title') BikeShop | Add category  @stop
@section('content')
    <h1>Add category</h1>
    <ul class="breadcrumb">
        <li><a href="{{ URL::to('category') }}">Home</a></li>
        <li class="active">Add category </li>
    </ul>
    {!! Form::open(array('action' => 'App\Http\Controllers\CategoryController@insert', 
    'method' => 'post', 'enctype' => 'multipart/from-data'))!!}

    @if($errors->any())
    <div class="alert alert-danger">
        @foreach ($errors->all() as $error)
            <div>{{ $error }}</div>
        @endforeach
    </div>
    @endif

    <div class="panel panel-default">
        <div class="panel-heading">

            <div class="panel-title">
                <strong>Category details </strong>
            </div>

        </div>
    
        <div class="panel-body">
        <table>
            <tr>
                <td>
                    {{ Form::label('name', 'Category name') }}
                </td>
                <td>
                    {{ Form::text('name', Request::old('name'), ['class'=>'form-control']) }}
                </td>
            </tr>

        </table>
        </div>

        <div class="panel-footer">
            <button type="reset" class="btn btn-danger"> Cancle </button>
            <button type="submit" class="btn btn-primary"><i class="fa fa-save"> Save </i></button>
        </div>

        {!! Form::close() !!}
@endsection