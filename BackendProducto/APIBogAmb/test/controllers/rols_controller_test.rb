require 'test_helper'

class RolsControllerTest < ActionDispatch::IntegrationTest
  setup do
    @rol = rols(:one)
  end

  test "should get index" do
    get rols_url, as: :json
    assert_response :success
  end

  test "should create rol" do
    assert_difference('Rol.count') do
      post rols_url, params: { rol: { nombre: @rol.nombre } }, as: :json
    end

    assert_response 201
  end

  test "should show rol" do
    get rol_url(@rol), as: :json
    assert_response :success
  end

  test "should update rol" do
    patch rol_url(@rol), params: { rol: { nombre: @rol.nombre } }, as: :json
    assert_response 200
  end

  test "should destroy rol" do
    assert_difference('Rol.count', -1) do
      delete rol_url(@rol), as: :json
    end

    assert_response 204
  end
end
