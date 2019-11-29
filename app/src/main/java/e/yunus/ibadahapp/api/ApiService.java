package e.yunus.ibadahapp.api;

import e.yunus.ibadahapp.model.ModelJadwalSholat;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("surabaya.json")
    Call<ModelJadwalSholat> getJadwalSholat();
}
