@extends('layouts.master') 
@section('title') BikeShop | Add product  @stop
@section('content')
    <h1>Add product</h1>
    <ul class="breadcrumb">
        <li><a href="{{ URL::to('product') }}">Home</a></li>
        <li class="active">Add product </li>
    </ul>
    {!! Form::open(array('action' => 'App\Http\Controllers\ProductController@insert', 
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
                <strong>Product details </strong>
            </div>

        </div>
    
        <div class="panel-body">
        <table>
            <tr>
                <td>
                    {{ Form::label('code', 'Product id') }}
                </td>
                <td>
                    {{ Form::text('code', Request::old('code'), ['class'=>'form-control']) }}
                </td>
            </tr>

            <tr>
                <td>
                    {{ Form::label('name', 'Product name') }}
                </td>
                <td>
                    {{ Form::text('name', Request::old('name'), ['class'=>'form-control']) }}
                </td>
            </tr>

            <tr>
                <td>
                    {{ Form::label('category_id', 'Product category') }}
                </td>
                <td>
                    {{ Form::select('category_id',$categories, Request::old('category_id'), 
                    ['class'=>'form-control']) }}
                </td>
            </tr>

            <tr>
                <td>
                    {{ Form::label('stock_qty', 'Product left') }}
                </td>
                <td>
                    {{ Form::text('stock_qty', Request::old('stock_qty'), ['class'=>'form-control']) }}
                </td>
            </tr>

            <tr>
                <td>
                    {{ Form::label('price', 'Product price') }}
                </td>
                <td>
                    {{ Form::text('price', Request::old('price'), ['class'=>'form-control']) }}
                </td>
            </tr>

            <tr>
                <td>
                    {{ Form::label('image', 'Product image') }}
                </td>
                <td>
                    {{ Form::file('image', Request::old('image'), ['class'=>'form-control']) }}
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