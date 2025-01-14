---
id: "index"
title: "admob-plus-cordova"
slug: "/cordova/api"
sidebar_label: "Exports"
sidebar_position: 0.5
custom_edit_url: null
---

## Enumerations

- [AdSizeType](enums/adsizetype.md)
- [Events](enums/events.md)
- [MaxAdContentRating](enums/maxadcontentrating.md)
- [NativeActions](enums/nativeactions.md)
- [Platforms](enums/platforms.md)
- [TrackingAuthorizationStatus](enums/trackingauthorizationstatus.md)

## Classes

- [AdMob](classes/admob.md)
- [AppOpenAd](classes/appopenad.md)
- [BannerAd](classes/bannerad.md)
- [InterstitialAd](classes/interstitialad.md)
- [MobileAd](classes/mobilead.md)
- [NativeAd](classes/nativead.md)
- [RewardedAd](classes/rewardedad.md)
- [RewardedInterstitialAd](classes/rewardedinterstitialad.md)

## Interfaces

- [BannerAdOptions](interfaces/banneradoptions.md)
- [RewardedAdOptions](interfaces/rewardedadoptions.md)
- [RewardedInterstitialAdOptions](interfaces/rewardedinterstitialadoptions.md)
- [ServerSideVerificationOptions](interfaces/serversideverificationoptions.md)

## References

### default

Renames and exports: [AdMob](classes/admob.md)

## Type aliases

### AdMobConfig

Ƭ **AdMobConfig**: { `appMuted?`: `boolean` ; `appVolume?`: `number`  } & [`RequestConfig`](index.md#requestconfig)

#### Defined in

code/github/admob-plus/packages/cordova/ts/api.ts:120

___

### MobileAdOptions

Ƭ **MobileAdOptions**: `Object`

**`internal`**

#### Type declaration

| Name | Type |
| :------ | :------ |
| `adUnitId` | `string` |
| `contentUrl?` | `string` |
| `id?` | `number` |
| `keywords?` | `string`[] |
| `npa?` | ``"1"`` |

#### Defined in

code/github/admob-plus/packages/cordova/ts/api.ts:6

___

### RequestConfig

Ƭ **RequestConfig**: `Object`

#### Type declaration

| Name | Type |
| :------ | :------ |
| `maxAdContentRating?` | [`MaxAdContentRating`](enums/maxadcontentrating.md) |
| `tagForChildDirectedTreatment?` | `boolean` \| ``null`` |
| `tagForUnderAgeOfConsent?` | `boolean` \| ``null`` |
| `testDeviceIds?` | `string`[] |

#### Defined in

code/github/admob-plus/packages/cordova/ts/api.ts:101

## Functions

### execAsync

▸ `Const` **execAsync**(`action`, `args?`): `Promise`<`unknown`\>

#### Parameters

| Name | Type |
| :------ | :------ |
| `action` | [`NativeActions`](enums/nativeactions.md) |
| `args?` | `any`[] |

#### Returns

`Promise`<`unknown`\>

#### Defined in

code/github/admob-plus/packages/cordova/ts/generated.ts:79
