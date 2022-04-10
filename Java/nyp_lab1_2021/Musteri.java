package nyp_lab1_2021;

public class Musteri {
	private String ad;
	private String soyad;
	Siparis[] siparisler=new Siparis[3];
	Musteri(String ad,String soyad) {
		this.ad=ad;
		this.soyad=soyad;
		for(int i=0; i<3;i++) {
			this.siparisler[i]=new Siparis();
		}
	}
	
	
	public void siparisVer(int siparisNo, Urun urun){
		this.siparisler[siparisNo].urunEkle(urun);
	}
	public void siparisBilgisi(int siparisNo) {
		System.out.println(siparisNo+" nolu sipari�e ait �r�n bilgileri");
		siparisler[siparisNo].urunleriGoster();
	}
	public void tumSiparisler() {
		System.out.println(ad+" "+soyad+" isimli m��teriye ait �r�n bilgileri:");
		for(int i=0; i<siparisler.length; i++) {
			System.out.println(i+" nolu sipari�e ait �r�n bilgileri");
			siparisler[i].urunleriGoster();
		}
	}
	public void kacSiparis(String urunAdi) {
		int index=0,sipsayisi=0,control=0;
		for(Siparis siparis:siparisler) {
			Urun[] urunler=siparis.getUrunler();
			for(Urun urun:urunler) {
				if(urun.getAd()==urunAdi) {
					index++;
					control=1;
				}
			}
			if(control==1) {
				sipsayisi++;
			}
			control=0;
		}
		System.out.println(sipsayisi+" tane sipari� i�inde toplam "+index+" adet "+urunAdi+" sipari� edilmi�");
		
	}
	public void tumSiparislerdenUrunCikar(Urun urun) {
		for(int i=0; i<siparisler.length; i++) {
			siparisler[i].urunCikar(urun);	
		}
	}
	public void urunCikar(int siparisNo, Urun urun) {
		siparisler[siparisNo].urunCikar(urun);
	}
	public double getSiparisTutari(int siparisNo) {
		return siparisler[siparisNo].getToplamTutar();
	}
}
