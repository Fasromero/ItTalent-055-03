require 'test_helper'

class LocalidadsControllerTest < ActionDispatch::IntegrationTest
  setup do
    @localidad = localidads(:one)
  end

  test "should get index" do
    get localidads_url, as: :json
    assert_response :success
  end

  test "should create localidad" do
    assert_difference('Localidad.count') do
      post localidads_url, params: { localidad: { nombre: @localidad.nombre } }, as: :json
    end

    assert_response 201
  end

  test "should show localidad" do
    get localidad_url(@localidad), as: :json
    assert_response :success
  end

  test "should update localidad" do
    patch localidad_url(@localidad), params: { localidad: { nombre: @localidad.nombre } }, as: :json
    assert_response 200
  end

  test "should destroy localidad" do
    assert_difference('Localidad.count', -1) do
      delete localidad_url(@localidad), as: :json
    end

    assert_response 204
  end
end
