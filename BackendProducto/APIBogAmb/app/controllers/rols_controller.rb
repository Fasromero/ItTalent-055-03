class RolsController < ApplicationController
  before_action :set_rol, only: [:show, :update, :destroy]

  # GET /rols
  def index
    @rols = Rol.all

    render json: @rols
  end

  # GET /rols/1
  def show
    render json: @rol
  end

  # POST /rols
  def create
    @rol = Rol.new(rol_params)

    if @rol.save
      render json: @rol, status: :created, location: @rol
    else
      render json: @rol.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /rols/1
  def update
    if @rol.update(rol_params)
      render json: @rol
    else
      render json: @rol.errors, status: :unprocessable_entity
    end
  end

  # DELETE /rols/1
  def destroy
    @rol.destroy
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_rol
      @rol = Rol.find(params[:id])
    end

    # Only allow a trusted parameter "white list" through.
    def rol_params
      params.require(:rol).permit(:nombre)
    end
end
