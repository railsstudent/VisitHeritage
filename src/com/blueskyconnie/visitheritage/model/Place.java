package com.blueskyconnie.visitheritage.model;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.common.base.Strings;
import com.google.common.collect.ComparisonChain;

public class Place implements Comparable<Place>, Parcelable, Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String imgUrl;
	private String description;
	private String email;
	private String homepage;
	private String remark;
	private String openingHour;
	private String phone;
	private String name_en;
	private String description_en;
	private String remark_en;
	private String openingHour_en;
	private double lat;
	private double lng;
	private int district;
	//private double distance;
	
	public Place(PlaceBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.imgUrl = builder.imgUrl;
		this.description = builder.description;
		this.email = builder.email;
		this.homepage = builder.homepage;
		this.remark = builder.remark;
		this.openingHour = builder.openingHour;
		this.phone = builder.phone;
		this.name_en = builder.name_en;
		this.description_en = builder.description_en;
		this.remark_en = builder.remark_en;
		this.lat = builder.lat;
		this.lng = builder.lng;
		this.district = builder.district;
	//	this.distance = builder.distance;
		this.openingHour_en = builder.openingHour_en;
	}
	
	public Place(Parcel in) {
	//	categoryId = in.readInt();
	//	category = in.readString();
	//	in.readStringList(imageUrl);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return imgUrl;
	}

	public void setUrl(String url) {
		this.imgUrl = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOpeningHour() {
		return openingHour;
	}

	public void setOpeningHour(String openingHour) {
		this.openingHour = openingHour;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName_en() {
		return name_en;
	}

	public void setName_en(String name_en) {
		this.name_en = name_en;
	}

	public String getDescription_en() {
		return description_en;
	}

	public void setDescription_en(String description_en) {
		this.description_en = description_en;
	}

	public String getRemark_en() {
		return remark_en;
	}

	public void setRemark_en(String remark_en) {
		this.remark_en = remark_en;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

//	public void setDistance(double distance) {
//		this.distance = distance;
//	}
//	
//	public double getDistance() {
//		return distance;
//	}

	public String getOpeningHour_en() {
		return openingHour_en;
	}

	public void setOpeningHour_en(String openingHour_en) {
		this.openingHour_en = openingHour_en;
	}

	@Override
	public int compareTo(Place other) {
		// sort distance in ascending order
		return ComparisonChain.start().compare(id, other.id).result();
	}
	
	public static class PlaceBuilder {

		private int id;
		private String name;
		private String imgUrl;
		private String description;
		private String email;
		private String homepage;
		private String remark;
		private String openingHour;
		private String phone;
		private String name_en;
		private String description_en;
		private String remark_en;
		private double lat;
		private double lng;
		private int district;
//		private double distance;
		private String openingHour_en;

		public PlaceBuilder id(int id) {
			this.id = id;
			return this;
		}
		
		public PlaceBuilder name(String name) {
			this.name = Strings.nullToEmpty(name);
			return this;
		}
		
		public PlaceBuilder imgUrl(String imgUrl) {
			this.imgUrl = Strings.nullToEmpty(imgUrl);
			return this;
		}

		public PlaceBuilder description(String description) {
			this.description = Strings.nullToEmpty(description);
			return this;
		}

		public PlaceBuilder email(String email) {
			this.email = Strings.nullToEmpty(email);
			return this;
		}
		
		public PlaceBuilder homepage(String homepage) {
			this.homepage = Strings.nullToEmpty(homepage);
			return this;
		}
		
		public PlaceBuilder remark(String remark) {
			this.remark = Strings.nullToEmpty(remark);
			return this;
		}
		
		public PlaceBuilder openingHour(String openingHour) {
			this.openingHour = Strings.nullToEmpty(openingHour);
			return this;
		}
		
		public PlaceBuilder phone(String phone) {
			this.phone = Strings.nullToEmpty(phone);
			return this;
		}
		
		public PlaceBuilder name_en(String name_en) {
			this.name_en = Strings.nullToEmpty(name_en);
			return this;
		}
		
		public PlaceBuilder description_en(String description_en) {
			this.description_en = Strings.nullToEmpty(description_en);
			return this;
		}
		
		public PlaceBuilder remark_en(String remark_en) {
			this.remark_en = Strings.nullToEmpty(remark_en);
			return this;
		}
		
		public PlaceBuilder lat(double lat) {
			this.lat = lat;
			return this;
		}
		
		public PlaceBuilder lng(double lng) {
			this.lng = lng;
			return this;
		}
		
		public PlaceBuilder district(int district) {
			this.district = district;
			return this;
		}
		
//		public PlaceBuilder distance(double distance) {
//			this.distance = distance;
//			return this;
//		}

		public PlaceBuilder openingHour_en(String openingHour_en) {
			this.openingHour_en = Strings.nullToEmpty(openingHour_en);
			return this;
		}

		public Place build() {
			return new Place(this);
		}
	}

	@Override
	public int describeContents() {
		return this.hashCode();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeString(imgUrl);
		dest.writeString(description);
		dest.writeString(email);
		dest.writeString(homepage);
		dest.writeString(remark);
		dest.writeString(openingHour);
		dest.writeString(phone);
		dest.writeString(name_en);
		dest.writeString(description_en);
		dest.writeString(remark_en);
		dest.writeString(openingHour_en);
		dest.writeDouble(lat);
		dest.writeDouble(lng);
		dest.writeInt(district);
	}
	
	public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>() {

		@Override
		public Place createFromParcel(Parcel source) {
			return new Place(source);
		}

		@Override
		public Place[] newArray(int size) {
			return new Place[size];
		}
	};
}
